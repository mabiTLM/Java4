function modal_git_address(git_address) {
  document.getElementById("modal-container").classList.add("git");
  document.getElementById("modal-msg").innerHTML = git_address;
}

var postUserNames = document.getElementsByClassName("postUserName");

for (var i = 0; i < postUserNames.length; i++) {
  postUserNames[i].addEventListener("mouseover", function (e) {
    var mousey = e.clientY;
    var modal = document.getElementsByClassName("git")[0];
    modal.style.top = mousey + "px";
  });

  postUserNames[i].addEventListener("mouseleave", function () {
    var modal = document.getElementsByClassName("git")[0];
    modal.style.top = 0;
    document.getElementById("modal-container").classList.remove("git");
    document.getElementById("modal-msg").innerHTML = "";
  });
}
// document.addEventListener("DOMContentLoaded", function () {
//   document
//     .getElementById("modal-box")
//     .addEventListener("mouseover", function () {
//       document.getElementById("modal-container").classList.add("git");
//     });

//   document.getElementById("modal-box").onmouseleave = () => {
//     document.getElementById("modal-container").classList.remove("git");
//   };
// });

// 실패했던 코드들 복습용
// document.getElementsByClassName("postUserName").mouseleave = (e) => {
//   document.getElementById("modal-container").classList.remove("git");
//   document.getElementById("modal-msg").innerHTML = "";
// };

// document.getElementsByClassName("postUserName").onmouseover = (e) => {
//   var mousex = e.clientX;
//   var mousey = e.clientY;
//   var modal = document.getElementsByClassName("git")[0];

//   modal.style.left = mousex + "px";
//   modal.style.top = mousey + "px";
// };
