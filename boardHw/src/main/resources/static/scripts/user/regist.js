function finalCheck() {
  document.getElementById("regist").onsubmit = (e) => {
    const id_check = /^[a-z|A-Z|0-9|]+$/;
    if (
      !id_check.test(document.getElementById("user-id").value) ||
      document.getElementById("user-id").value.length < 2 ||
      document.getElementById("user-id").value.length > 21
    ) {
      e.preventDefault();
      alert("아이디는 영어 또는 숫자 3~20만 가능합니다");
    }

    const password_check =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&])[A-Za-z\d!@#$%^&]{10,30}$/;
    if (
      !password_check.test(document.getElementById("resist-password").value)
    ) {
      e.preventDefault();
      alert("비밀번호는 대소문자 특수문자(!@#$%^&)포함 10~30자리입니다.");
    }

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
    }
    if (currentByte > maxByte || currentByte < 4) {
      e.preventDefault();
      alert("이름은 한글 2~10 , 영어 4~20까지만 입력가능합니다");
    }
    /////////////////////////////////////////////////////////////////////////
    var slashPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

    if (slashPhone.test(document.getElementById("phone").value) == true) {
      document.getElementById("phone").setCustomValidity("");
    } else {
      e.preventDefault();
      alert("전화번호는 숫자10~11 또는 -포함 12~13");
    }

    if (
      document.getElementById("address").value == "" ||
      (document.getElementById("address").value.length > 4 &&
        document.getElementById("address").value.length < 101)
    ) {
    } else {
      e.preventDefault();
      alert("주소는 5~10글자");
    }

    if (
      document.getElementById("email").value.endsWith(".com") ||
      document.getElementById("email").value.endsWith(".org") ||
      document.getElementById("email").value.endsWith(".co.kr") ||
      document.getElementById("email").value.endsWith(".net")
    ) {
    } else {
      e.preventDefault();
      alert(".com || .org || .co.kr || .net 으로 종료될 것");
    }
  };
}
