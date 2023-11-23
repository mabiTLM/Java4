function modal_git_address(git_address) {
  document.getElementById("modal-container").classList.add("on");

  document.getElementById("modal-msg").innerHTML = git_address;
}

function modal_out() {
  document.getElementById("modal-container").classList.remove("on");
  document.getElementById("modal-msg").innerHTML = "";
}
