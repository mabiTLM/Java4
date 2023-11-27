function dateChange(e) {
  var tempDate = new Date(e);
  return (
    tempDate.getFullYear() +
    "." +
    tempDate.getMonth() +
    "." +
    tempDate.getDate() +
    " " +
    tempDate.getHours() +
    " : " +
    tempDate.getMinutes()
  );
}

const commentListElem = document.getElementById("comment-list");

const getList = async () => {
  const list = (
    await axios.get(`/comments?boardId=${commentListElem.dataset.boardId}`)
  ).data;
  console.log(list);

  list.forEach((item) => {
    const tempLiElem = document.createElement("li");
    tempLiElem.innerHTML = `${item.content} - ${item.name} - ${dateChange(
      item.createdAt
    )}`;
    const tempOlElem = document.createElement("ul");
    item.children.forEach((child) => {
      const tempLiElem2 = document.createElement("li");
      tempLiElem2.innerHTML = `${child.content} - ${child.name} - ${dateChange(
        child.createdAt
      )}`;
      ///////////////
      const tempOlElem2 = document.createElement("ul");
      child.children.forEach((child2) => {
        const tempLiElem3 = document.createElement("li");
        tempLiElem3.innerHTML = `${child2.content} - ${
          child2.name
        } - ${dateChange(child2.createdAt)}`;
        /////////////////////
        const tempOlElem3 = document.createElement("ul");
        child2.children.forEach((child3) => {
          const tempLiElem4 = document.createElement("li");
          tempLiElem4.innerHTML = `${child3.content} - ${
            child3.name
          } - ${dateChange(child3.createdAt)}`;
          tempOlElem3.append(tempLiElem4);
        });
        tempLiElem3.append(tempOlElem3);
        ////////////////////
        tempOlElem2.append(tempLiElem3);
      });
      tempLiElem2.append(tempOlElem2);
      ////////////////
      tempOlElem.append(tempLiElem2);
    });
    tempLiElem.append(tempOlElem);

    commentListElem.append(tempLiElem);
  });
};
getList();

let number = 1;
var tempOlArr = [];
var tempLiArr = [];
function reply(a) {
  tempOlArr[number] = document.createElement("ul");
  a.children.forEach((b) => {
    tempLiArr[number] = document.createElement("li");
    tempLiArr.innerHTML = `${b.content} - ${b.name} - ${dateChange(
      b.createdAt
    )}`;
    if (b.children != null) {
      number++;
      reply(b);
    }
    tempOlArr[number].append(tempLiArr);
    number--;
  });
}
