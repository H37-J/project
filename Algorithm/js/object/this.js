let user={
    name:'tt'
};

user.say=function(){
    console.log(this.name);
}

user.say();