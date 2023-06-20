async function postcmtToServer(cmtData){
    try{
        const url = '/comment/post';
        const config = {
            method : 'post',
            headers : {
                'content-type':'application/json; charset=utf-8',
            },
            body : JSON.stringify(cmtData),
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    }catch(err){
        console.log(err);
    }
    
}
document.getElementById('cmtPostBtn').addEventListener('click', ()=>{
const cmtText = document.getElementById('cmtText').value;
console.log(cmtText);
if(cmtText == "" || cmtText == null){
alert('댓글을 입력해주세요');
document.getElementById('cmtText').focus();
return false;
}else{
    let cmtData = {
        bno : bnoVal,
        writer : document.getElementById('cmtWriter').innerText,
        content : cmtText
    };
    console.log(cmtData);
    postcmtToServer(cmtData).then(result =>{
        if(result > 0){
            alert('댓글 등록 성공 : ' + cmtData.content);
            getCmtList(cmtData.bno);
        }
    })
    document.getElementById('cmtText').value = "";
}
})

async function spreadCmtFromServer(bno){
    console.log(' >>>>> bno >>>>> : ' +bno);
    try{
        const resp = await fetch('/comment/list/' + bno);
        const result = await resp.json();
        return result;
    }catch(err){
        console.log(err);
    }
}


function getCmtList(bno){
    spreadCmtFromServer(bno).then(result =>{
        console.log(' >>>>> result >>>>> ' + result);
        const ul = document.getElementById('cmtListArea');
        if(result.length>0){
            ul.innerHTML = "";
            for(let cvo of result){
                let li = `<li data-cno="${cvo.cno}"><div><div>${cvo.writer}</div>`;
                li += `<input type="text" id="cmtTextMod" value="${cvo.content}"></div>`;
                li += `<span>${cvo.reg_date}</span>  &nbsp &nbsp <br>`;
                li += `<button type="button" class="ModBtn edit-button">수정</button> &nbsp &nbsp`;
                
                li += `<button type="button" class="DelBtn delete-button">삭제</button></li><br> <hr>`;
                ul.innerHTML+=li;
            }
        }else{
            let li =`<li>댓글리스트가 없습니다.</li>`;
            ul.innerHTML+=li;
        }
    })
}
document.addEventListener('click', function(event) {
  console.log(event.target);
    if (event.target.classList.contains('ModBtn')) {
      const parentLi = event.target.parentNode;
      const cno = parentLi.dataset.cno;
      const cmtTextMod = parentLi.querySelector('#cmtTextMod').value;
        
      const cmtData = {
        bno: bnoVal,
        cno: cno,
        writer: document.getElementById('cmtWriter').innerText,
        content: cmtTextMod
      };
      postcmtUpdateToServer(cmtData).then(result => {
        if (result > 0) {
          alert('댓글 수정 성공: ' + cmtData.content);
          getCmtList(cmtData.bno);
        }else{
            alert('댓글 수정 실패 : ')
        }
      });
    }
  });


  document.addEventListener('click', function(event) {
    if (event.target.classList.contains('DelBtn')) {
      const parentLi = event.target.parentNode;
      const cno = parentLi.dataset.cno;
      postcmtDeleteToServer(cno).then(result => {
        if (result > 0) {
          alert('댓글 삭제 성공');
          getCmtList(bnoVal);
        }
      });
    }
  });
  async function postcmtUpdateToServer(cmtData) {
    try {
      const url = '/comment/update';
      const config = {
        method: 'post',
        headers: {
            'content-type': 'application/json; charset=utf-8',
        },
        body: JSON.stringify(cmtData),
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
        } catch (err) {
        console.log(err);
        }
        }
        async function postcmtDeleteToServer(cno) {
        try {
        const url = '/comment/delete/' + cno;
        const config = {
        method: 'post',
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
        } catch (err) {
        console.log(err);
        }
        }
        document.querySelectorAll('.ModBtn').forEach(button => {
          button.classList.add('edit-button');
      });
      document.querySelectorAll('.DelBtn').forEach(button => {
        button.classList.add('delete-button');
    });
          
  