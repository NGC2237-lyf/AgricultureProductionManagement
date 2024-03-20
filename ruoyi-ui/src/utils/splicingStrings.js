export  const  splicingStrings = (strArr)=> {
  // 字符串拼接
  let str = '';
  for(let i=0;i<strArr.length ;i++){
    if(i !==strArr.length-1){
      str = str + strArr[i]+ "/";
    }
    else {
      str = str + strArr[i];
    }
  }
  return str;
}
