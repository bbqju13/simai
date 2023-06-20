document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$");
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$");

const maxSize = 1024*1024*20;
function fileSizeValidation(fileName, fileSize){
    if(regExp.test(fileName)){
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else if(!regExpImg.test(fileName)){
        return 0;
    }
    else{
        return 1;
    }
}

document.addEventListener('change',(e)=>{
    console.log('e >>>>> : ' + e.target);
    if(e.target.id == 'file'){
        document.getElementById('regBtn').disabled = false;
        const fileObj = document.getElementById('file').files;
        console.log(fileObj);

        let div = document.getElementById('fileZone');
        div.innerHTML = '';
        let ul = `<ul>`;
        let isOk = 1;
        for(let file of fileObj){
            let vaildResult = fileSizeValidation(file.name, file.size);
            isOk *= vaildResult;
            ul += `<li>`;
            ul += `${vaildResult ? '<div>업로드 가능' : '<div>업로드 불가능'} </div>`;
            ul += `${file.name}`;
            ul += `<span class="badge rounded-pill text-bg-${vaildResult ? 'success' : 'danger'}">${file.size} Bytes </span></li>`;
        }
        ul += `</ul>`;
        div.innerHTML = ul;

        if(isOk == 0){
            document.getElementById('regBtn').disabled = true;
        }
    }
})