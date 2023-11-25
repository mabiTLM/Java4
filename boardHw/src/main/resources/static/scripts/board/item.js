const read_area = document.getElementsByClassName("comment-read-area").length;

for (let i = 0; i < read_area; i++) {
  document.getElementsByClassName("comment-read-area")[i].onclick = () => {
    if (
      document.getElementsByClassName("comment-text-area")[i].style.display ==
      "none"
    ) {
      document.getElementsByClassName("comment-text-area")[i].style.display =
        "block";
    } else {
      document.getElementsByClassName("comment-text-area")[i].style.display =
        "none";
    }
  };
}
