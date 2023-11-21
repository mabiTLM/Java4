document.getElementById("regist").onsubmit = (e) => {
  const maxByte = 20;
  const input_text = document.getElementById("name").value;
  const text_length = input_text.length;

  let currentByte = 0;

  for (let i = 0; i < text_length; i++) {
    const temp_char = input_text.charAt(i);
    const unicode_temp = escape(temp_char);
    if (unicode_temp.length > 4) {
      currentByte += 2;
    } else {
      currentByte += 1;
    }

    if (currentByte > maxByte || currentByte < 4) {
      e.preventDefault();
      alert("한글 2~10 , 영어 4~20까지만 입력가능합니다");
      document.getElementById("name").value = document
        .getElementById("name")
        .value.slice(0, -1);
    }
  }
  /////////////////////////////////////////////////////////////////////////
  var slashPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

  if (slashPhone.test(document.getElementById("phone").value) == true) {
    document.getElementById("phone").setCustomValidity("");
  } else {
    e.preventDefault();
    alert("숫자10~11 또는 -포함 12~13");
  }
};
