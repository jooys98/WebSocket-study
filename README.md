🌟간단한 websocket 구현 


#WebSocket이란?

- 클라이언트와 서버 간의 양방향 실시간 통신을 가능하게 하는 프로토콜
- 한번 연결이 수립되면 계속 연결을 유지하며 실시간으로 데이터를 주고받을 수 있음
- HTTP(일회성 연결) 와 달리 연결을 유지하므로 실시간 기능 구현에 적합

#STOMP (Simple Text Oriented Messaging Protocol)

- WebSocket 위에서 동작하는 메시징 프로토콜
- 메시지의 형식과 규칙을 정의하여 구조화된 통신 가능

#HTTP VS STOMP 




<img width="420" alt="스크린샷 2025-02-02 오후 11 50 10" src="https://github.com/user-attachments/assets/199efba5-01a9-4ce4-b3c1-75962026d51e" />

  

#통신 과정 
1. 클라이언트가 `/app/chat`으로 메시지를 보냄
2. 서버는 `/app`을 보고 "이건 내가 처리해야 할 메시지구나" 라고 인식
3. `/app` 뒤의 `/chat`을 보고 `@MessageMapping("/chat")` 메서드를 찾아서 실행

- 우체국 주소체계와 비슷함
- `/app`은 '서울시'같은 큰 지역을
- `/chat`은 '강남구'같은 세부 주소
- 편지(메시지)는 이 둘을 합친 전체 주소로 배달
