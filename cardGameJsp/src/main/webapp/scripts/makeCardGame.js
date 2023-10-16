let card = ["2연참","공격","공격","공격","굳히기","방어","방어","방어"];//카드의 고유아이디만 저장해두자

let playerHp = 200;
let playerDef = 0;
let playerMaxMana = 5;
let playerMana = 5;

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

/////// 몬스터처리
let monsterCount =-1;
let monsterHp=[-1,-1,-1,-1];
let monsterDef=[-1,-1,-1,-1];
let currentTarget;

function target(num,Hp,Def,count) {
	currentTarget=num;
	console.log(count);
	if(monsterHp[num]==-1)
	{
		monsterHp[num]=Hp;
	}
	if(monsterDef[num]==-1)
	{
		monsterDef[num]=Def;
	}
	if(monsterCount==-1)
	{
		monsterCount=count;
	}
}
function usecard(type,value,consumeMana) {
	
	if(playerMana-consumeMana<0)
	{
		alert("마나가 부족합니다");
	}
	else if(type=="Attack")
	{
		playerMana=playerMana-consumeMana;
		const playerManaPrint = document.getElementById("playerManaSpan");
		playerManaPrint.innerHTML = playerMana;
		
		const monsterDefPrint = document.getElementById("monsterDef"+currentTarget);
		const monsterHpPrint = document.getElementById("monsterHp"+currentTarget);
		monsterDef[currentTarget] -= value;
		if(monsterDef[currentTarget]<0)
		{
			monsterHp[currentTarget]-=Math.abs(monsterDef[currentTarget]);
			monsterDef[currentTarget]=0;
		}
		monsterDefPrint.innerHTML = monsterDef[currentTarget];
		monsterHpPrint.innerHTML = monsterHp[currentTarget];
		if(monsterHp[currentTarget]<=0)
		{
			monsterHp[currentTarget]=0;
			monsterHpPrint.innerHTML = monsterHp[currentTarget];
			const target= document.getElementById("monster"+currentTarget);
			target.disabled = true;
			monsterCount=monsterCount-1;
			currentTarget=-1;
		}
		
		if(monsterCount<=0){
			monsterCount=-1;
			const finish = document.getElementById("finish");
		finish.setAttribute('type','submit');
		}
	}
	else if(type=="Defend")
	{
		playerMana=playerMana-consumeMana;
		const playerManaPrint = document.getElementById("playerManaSpan");
		playerManaPrint.innerHTML = playerMana;
		
		playerDef= playerDef + value;
		
		const playerDefPrint = document.getElementById("playerDefSpan");
		playerDefPrint.innerHTML = playerDef;	
	}
}

function turnFinish(){
	playerMana=playerMaxMana;
	const playerManaPrint = document.getElementById("playerManaSpan");
	playerManaPrint.innerHTML = playerMana;

}