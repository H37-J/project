
let list = {
    value: 1,
    next: {
      value: 2,
      next: {
        value: 3,
        next: {
          value: 4,
          next: null
        }
      }
    }
  };
console.log(list);

// let list2 = { value: 1 };
// list2.next = { value: 2 };
// list2.next.next = { value: 3 };
// list2.next.next.next = { value: 4 };
// list2.next.next.next.next = null;

//삭제
let secondList=list.next.next;
list.next.next=null;

//합치기
list.next.next=secondList;

//중간요소 제거
list.next=list.next.next;

//값의 추가 방법
list={value:"new item", next:list};

console.log(list);

