function query(){
    let elements=document.querySelector('ul > li');

    for(let elem of elements){
        console.log(elem.innerHTML);
    }
}



//form관련
function formElement(){
    let login=form.elements.login; //<input name="login> 이 된다
}


//select
function select(){
    let select=document.querySelector('#select');
    select.options // 하위 요소를 담고 있는 컬렉션
    select.value // option중에 현재 선택된 값
    select.selectedIndex //현재 선택된 option의 인덱스
}



function getSelected(){
    let selected=Array.from(select.options)
    .filter(option=>option.selected)
    .map(option=>option.value);

    console.log(selected);
}

//file관련
function showFile(){
    let file=document.getElementById('file');

    console.log(file.name);
    console.log(file.lastModified);
}



//네트워크 관련 fetch
let promise = fetch(url,[options]);

// 응답은 두 단계를 거처서 진행된다
// fetch 호출시 반환받은 promise가 내장 클래스 Response의 인스터스와 함께 이행 상태가 된다.
let url='https://api.github.com/repos/javascript-tutorial/en.javascript.info/commits';
let response = await fetch();
//status-HTTP code상태, ok=불린 값, 200~299일때 true
if(response.ok){ //200~299일때 true 실행을 의미
    let json=await response.json();
}else{
    console.log(json);
}

// res.text() 응답을 읽고 텍스트를 반환
// res.json() 응답을 읽고 json형태로 파싱
// res.formData() 응답을 FormData객체 형태로 반환
// res.blob() 응답을 Blob(타입이 있는 바이너리 데이터) 형태로 반환
// res.arrayBuffer 응답을 ArrayBuffer(바이너리 데이터를 로우 레벨려 형식한것) 형태로 반환

response=await fetch(url);
let commits=await response.json();
console.log(commits);

//크로스 오리진 요청에 대하여
//크로스 오리진 요청은 서버에서 명시적으로 크로스 오리진 요청을 ‘허가’ 했다는 것을 알려주는 특별한 헤더를 전송받았을 때만 가능하도록 제약을 걸게 됩니다.
