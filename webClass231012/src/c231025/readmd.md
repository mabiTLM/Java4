# VPN?

- Virtual Private Network
- IP 우회해서 다른데로 바꾼다? 보안도 늘린다?
- 우리 컴퓨터 -> VPN 서버 -> 다른 웹페이지 요청 -> VPN이 받고 -> 우리 컴퓨터

# Proxy
- 반대로 다른 곳에서 우리한테 보내준 걸 다른 웹페이지, 내부적으로 다른 port로 요청을 보내 처리하는 것
- "http://localhost" -> naver 출력
포워딩,데코레이터 패턴 등 상대방이 인식하는 것과 내가 구성한게 다를 때

# AWS
- 컴퓨터를 몇대 둘까? 3대? 1대? 프로젝트 개수만큼?
- 프로젝트가 크지 않다, 무겁지 않다 -> 1대
- 1대의 컴퓨터 안에서 프로젝트를 몇 개 배포할 수 있을까? => 몇개든 성능만 된다면
- Java:80(http), Node.js:8081, React:3000, GoLang:8082 => https:443
- 443/java => Java,
  443/node => Node.js,
  443/react => 3000(react),
  443/go => GoLang
- 외부 -> apache:443/java -> java:80 << proxy | reverse proxy => 옛날.xml, 요즘.conf
- Cross Origin Resources Sharing