let card = ["1", "21", "3"];

function setCookie(name, value) {
  var exdate = new Date();
  exdate.setDate(exdate.getDate() + 30);
  var cookie_value = escape(value) + "; expires=" + exdate.toUTCString();
  document.cookie = name + "=" + cookie_value;
}

function getCookie(name) {
  var x, y;
  var val = document.cookie.split(";");
  for (var i = 0; i < val.length; i++) {
    x = val[i].substr(0, val[i].indexOf("="));
    y = val[i].substr(val[i].indexOf("=") + 1);
    x = x.replace(/^\s+|\s+$/g, "");
    if (x == name) {
      return unescape(y);
    }
  }
}

function deleteCookie(name) {
  document.cookie = name + "=; expires=Thu, 01 Jan 1999 00:00:10 GMT;";
}

function newGame() {
  deleteCookie("deck");
  alert("새 게임을 불러옵니다");
  setCookie("deck", card);
}

function add(num) {
  card = getCookie("deck").split(",");
  card[card.length] = num;
  setCookie("deck", card);
}

function watchCard() {
  card = getCookie("deck").split(",");
  for (let i = 0; i < card.length; i++) {
    console.log(card[i]);
  }
}
