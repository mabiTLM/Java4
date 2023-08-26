package MakeGame_0824;

public class StoryText
{

int currentDay = 1; //경과일에 따른 스토리 변경이 있으므로 여기서 계산합니다.

int dayLimit =100;

private String start ="이동과 선택지는 숫자로 선택하며 스킬발동은 가진 스킬을 입력해서 사용합니다."

String[] mainStory={}

String[] endingStory=
{
"엔딩0 다시 일상으로/n동생은 완치 됐습니다.쌩쌩한것 앞으로 100년은 더 살것처럼보이네요."
"엔딩1 헛된 죽음/n당신은 던전에서 죽었습니다./n혼자 남겨진 당신의 동생도 곧 뒤따라가겠지요.",
"",

}


void timeRemaining()
{}


//set모음

void setCurrentDay(int currentDay)
{
this.currentDay=currentDay;
}
void setDayLimit(int dayLimit)
{
this.dayLimit=dayLimit;
}

//get모음

public int getCurrentDay()
{
return currentDay;
}
public int getDayLimit()
{
return dayLimit;
}
public String getStart()
{
return start;
}
public String[] getMainStory()
{
return mainStory;
}
public String[] getEndingStory()
{
return endingStory
}
}
