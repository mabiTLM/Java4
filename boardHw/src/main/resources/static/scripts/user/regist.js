$("#datePicker").datepicker({
  format: "yyyy-mm-dd",
  endDate: "1d",
  autoclose: true,
  clearBtn: true,
  title: "Birth day",
  language: "ko",
});

const idReg = /^[A-Za-z0-9]{3,20}$/;
const pwReg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&])(?=.*[0-9]).{10,30}$/;
const koreanReg = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
const englishReg = /[a-zA-Z]/g;
const phoneReg = /^\d{3}-[0-9]{3,4}-[0-9]{4}$/;
const emailReg = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+(.com|.net|.co.kr|.org)$/i;

document.getElementById("regist-form").onsubmit = function (e) {
  const tempName = e.target.name.value.replace(koreanReg, "aa");
  const tempPhone = e.target.phone.value.replace(
    /^(\d{3})(\d{3,4})(\d{4})$/,
    `$1-$2-$3`
  );

  let msg = checkId(e.target);
  if (!msg) msg = checkPassword(e.target);
  if (!msg) {
    if (
      tempName.length < 4 ||
      tempName.length > 20 ||
      !englishReg.test(tempName)
    ) {
      msg = "이름은 한글 2~10, 영어 4~20으로 입력해주세요";
    } else if (!phoneReg.test(tempPhone)) {
      msg = "전화 번호는 한국에서의 형식에 맞춰주세요";
    } else if (
      e.target.address.value.length > 0 &&
      (e.target.address.value.length < 5 || e.target.address.value.length > 100)
    ) {
      msg = "주소는 5~100자로 맞춰주세요";
    } else if (!emailReg.test(e.target.email.value)) {
      msg = "이메일 형식에 맞춰주세요.";
    }
  }

  if (!checkMsg(msg, e)) {
    e.target.phone.value = tempPhone;
    if (
      e.target.gitAddress.value.length > 0 &&
      !e.target.gitAddress.value.startsWith("https://github.com/")
    ) {
      e.target.gitAddress.value =
        "https://github.com/" + e.target.gitAddress.value;
    }
  }
};
