$("#datePicker").datepicker({
  format: "yyyy-mm-dd",
  //startDate: "-1d",
  endDate: "1d",
  autoclose: true,
  clearBtn: true,
  title: "Birth day",
  language: "ko",
  //multidate: true,
});

const idReg = /^[A-Za-z0-9]{3,20}$/;
const pwReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&])(?=.*[0-9]).{10,30}$/;
const koreanReg = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
const englishReg = /[a-zA-Z]/g;
const phoneReg = /^\d{3}-[0-9]{3,4}-[0-9]{4}$/; //\w영어 \d다이알로그 숫자 \s스페이스 \t탭 \뒤는 문자로 인식
const emailReg = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+(.com|.net|.co.kr|.org)$/i;

// document.getElementById("regist-form").userId.oninput = (e) => {
//   const temp = e.target.value.match(idReg);
//   console.log(temp);
//   if (temp.length) {
//     e.target.value = e.target.value.match(idReg).join("");
//   } else {
//     e.target.value = "";
//   }
// };

document.getElementById("regist-form").onsubmit = function (e) {
  //id => 3~20 영어 숫자
  const tempName = e.target.name.value.replace(koreanReg, "aa");
  const tempPhone = e.target.phone.value.replace(
    /^(\d{3})(\d{3,4})(\d{4})$/,
    `$1-$2-$3`
  );

  let msg = "";
  if (!idReg.test(e.target.userId.value)) {
    if (e.target.userId.value.length < 3 || e.target.userId.value.length > 20) {
      msg = "아이디의 길이는 3~20으로 해주세요.";
    } else {
      msg = "아이디는 영어와 숫자만 포함할 수 있어요.";
    }
  } else if (!pwReg.test(e.target.password.value)) {
    if (
      e.target.password.value.length < 10 ||
      e.target.password.value.length > 30
    ) {
      msg = "비밀번호 길이는 10~30으로 해주세요";
    } else {
      msg = "비밀번호는 대소문자, 숫자, 특수문자(!@#$%^&)를 포함해야해요.";
    }
  } else if (
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

  if (msg) {
    console.log(msg);
    e.preventDefault();
    document.getElementById("modal-container").classList.add("on");
    document.getElementById("modal-msg").innerHTML = msg;
  } else {
    e.target.phone.value = tempPhone;
    if (
      //e.target["git-address"]
      e.target.gitAddress.value.length > 0 &&
      !e.target.gitAddress.value.startsWith("https://github.com/")
    ) {
      e.target.gitAddress.value =
        "https://github.com/" + e.target.gitAddress.value;
    }
  }

  //   if (e.target.userId.value.length < 3 || e.target.userId.value.length > 20) {
  //     e.preventDefault();
  //     console.log("아이디가 길이가 안맞아");
  //   }
  //   if (!idReg.test(e.target.userId.value)) {
  //     e.preventDefault();
  //     console.log("아이디가 달라");
  //     // << 정규표현식 g글로벌 전부 i대소문자 +한개이상 조건 안맞는게 나오면 끊긴다
  //   }
};
// document.getElementById("parent").onclick = function () {
//   console.log("부모클릭");
// };
// document.getElementById("parent").onwheel = (e) => {
//   e.preventDefault();
// };

// document.getElementById("child1").onclick = function (e) {
//   e.stopPropagation();
//   console.log("child1 클릭");
// };

// document.getElementById("child2").onclick = function () {
//   console.log("자식2클릭");
// };

// document.getElementById("child-child").onclick = function () {
//   console.log("child-child클릭");
// };
