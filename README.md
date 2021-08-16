# be-teamD-cs-study

백엔드 데브코스 D팀의 CS 스터디

* 매 주 선정된 CS 주제들에 대해 각자 파트를 나눠서 조사하고 해당 내용을 발표를 통해 공유합니다.

<br>

## 📃Rules
### 👋모임 (21.08.09 기준)

- 온라인: 매주 (금) 백둥이 타임 이후(14시 30분 예상) - [팀 게더](https://gather.town/invite?token=QLtrS8zq)
- 기간: 2021.08.09(월) ~ 2021.08.27(금)

<br>

### 📝진행 (21.08.09 기준)
* 각 주차 별로 멘토님이 내주신 과제 혹은 면접 대비를 위한 CS 질문들로 주제를 선정합니다.
* 한 주제에 대해 여러 키워드들을 멤버 별로 파트를 나눕니다.
    * 파트 선정 기준은 사다리타기
* 각 파트를 맡은 멤버들은 조사한 내용을 스터디 전까지 PR 보내고 해당 주제에 대한 5분 내외 발표를 준비합니다.
* 모임 때 5분 발표 후 과제 진행 중 생겼던 질문들을 공유합니다.

<br>

### 💻Pull Request 

> *데브 코스 TIL PR 방식을 따름*

#### 💡 초기 설정
1. `be-teamD-cs-study` 저장소를 내 계정으로 fork (`prgrms-web-devcourse/be-teamD-cs-study` 저장소의 `{githubID}` 브랜치들은 미리 생성해놨습니다!)
2. fork된 repository에도 새로운 브랜치를 생성합니다. `{githubID}`
3. fork된 repository를 clone 받습니다.
4. 작업할 브랜치를 변경합니다 `git switch {githubID}`

#### 📤 Commit & PR
1. 각자 조사한 내용을 담은 week#/keyword.md 파일을 작성하고 commit push 합니다.
2. PR을 `be-teamD-cs-study:{githubID}` <= `{githubID}:{githubID}` 로 보냅니다.
    - ex. `be-teamD-cs-study:suhyunsim <- suhyunsim:suhyunsim`
3. Pull Request에 관련 주제 라벨을 달아줍니다.

<br>

### 📑Convention

- 브랜치 - github 아이디
- 폴더 구조
    - week#n (ex. `week1`)
        - `keyword.md` (ex. `Protocol.md`)

<br>
