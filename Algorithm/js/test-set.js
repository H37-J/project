let set = new Set(['1', '2', '3']);

//for
for (let value of set) {
  console.log(value);
}

for (let value in set) {
  console.log(value);
}

//add
set.add(4);

//has
set.has(4);

//delete
set.delete(4);

//clear
set.clear();

//size
console.log(set.size);
