# Welshcoding
</br>
Spring Boot 를 활용한 웹 개발 프로젝트 입니다.</br></br>

- 배포된 프로젝트 바로가기 : <a  href="https://port-0-welshcoding-rm6l2llvw6yzvu.sel5.cloudtype.app/" target="_blank"> Welshcoding 새창으로 열기</a>
- 노션에서 프로젝트 설명 보기 : <a  href="https://miniature-globe-4cc.notion.site/Spring-Boot-Welshcoding-184178242f938015b0a5d9f8a1688e14" target="_blank"> Welshcoding 노션 새창으로 열기</a>


</br></br>
---
</br></br>

### 프로젝트 소스 구조

```

...환경세팅 디렉토리 생략...
+---bin
|   +---default
|   +---generated-sources
|   |   \---annotations
|   +---generated-test-sources
|   |   \---annotations
|   +---main
|   |   |   application.properties_bak
|   |   |   application.yaml
|   |   |   
|   |   +---com
|   |   |   \---example
|   |   |       \---welshcoding
|   |   |           |   main.class
|   |   |           |   main2.class
|   |   |           |   main3.class
|   |   |           |   WelshcodingApplication.class
|   |   |           |   
|   |   |           +---controller
|   |   |           |       BoardController.class
|   |   |           |       EditController.class
|   |   |           |       HomeController.class
|   |   |           |       IntroduceController.class
|   |   |           |       LoginController.class
|   |   |           |       MemberController.class
|   |   |           |       SaveController.class
|   |   |           |       SeriesController.class
|   |   |           |       SignupController.class
|   |   |           |       TemporaryController.class
|   |   |           |       
|   |   |           +---domain
|   |   |           |       Board.class
|   |   |           |       Introduce.class
|   |   |           |       Member.class
|   |   |           |       Series.class
|   |   |           |       Sns.class
|   |   |           |       Tags.class
|   |   |           |       Temporary.class
|   |   |           |       
|   |   |           +---dto
|   |   |           |       BoardDTO.class
|   |   |           |       LoginDTO.class
|   |   |           |       MemberDTO.class
|   |   |           |       SeriesListDTO.class
|   |   |           |       TemporaryDTO.class
|   |   |           |       
|   |   |           +---exception
|   |   |           |       MemberNotFoundException.class
|   |   |           |       TagNullException.class
|   |   |           |       
|   |   |           +---interceptor
|   |   |           |       LoginCheckInterceptor.class
|   |   |           |       ReloadFilter.class
|   |   |           |       WebConfig.class
|   |   |           |       
|   |   |           +---repository
|   |   |           |       BoardRepository.class
|   |   |           |       IntroduceRepository.class
|   |   |           |       LoginRepository.class
|   |   |           |       MemberRepository.class
|   |   |           |       SeriesRepository.class
|   |   |           |       SignupRepository.class
|   |   |           |       TagRepository.class
|   |   |           |       TemporaryRepository.class
|   |   |           |       TestMemberRepository.class
|   |   |           |       
|   |   |           +---service
|   |   |           |       BoardService.class
|   |   |           |       IntroduceService.class
|   |   |           |       LoginService.class
|   |   |           |       MemberService.class
|   |   |           |       SeriesService.class
|   |   |           |       SignupService.class
|   |   |           |       TagService.class
|   |   |           |       TemporaryService.class
|   |   |           |       TestMemberService.class
|   |   |           |       
|   |   |           \---testjiwon
|   |   |                   TestSRepository.class
|   |   |                   TestSService.class
|   |   |                   TestTempoController.class
|   |   |                   TestTemporaryRepository.class
|   |   |                   TestTemporaryService.class
|   |   |                   
|   |   +---META-INF
|   |   |       persistence.xml
|   |   |       
|   |   +---static
|   |   |   |   index.html
|   |   |   |   
|   |   |   +---body1
|   |   |   |   |   boardScript.js
|   |   |   |   |   body.html
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           dog.jpg
|   |   |   |           emailIcon.png
|   |   |   |           facebookIcon.png
|   |   |   |           githubIcon.png
|   |   |   |           home-icon.png
|   |   |   |           home-icon.svg
|   |   |   |           icon_black.png
|   |   |   |           me_profile.png
|   |   |   |           search.png
|   |   |   |           twiterIcon.png
|   |   |   |           
|   |   |   +---css
|   |   |   |   |   edit_style.css
|   |   |   |   |   footerStyle.css
|   |   |   |   |   headerStyle.css
|   |   |   |   |   introduce.css
|   |   |   |   |   loginStyle.css
|   |   |   |   |   mainbody.css
|   |   |   |   |   postStyle.css
|   |   |   |   |   registerStyle.css
|   |   |   |   |   save_style.css
|   |   |   |   |   seriesStyle.css
|   |   |   |   |   setPage_styles.css
|   |   |   |   |   signstyle.css
|   |   |   |   |   tempstyle.css
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           corgi.png
|   |   |   |           icon.png
|   |   |   |           icon_grayScale.png
|   |   |   |           icon_mid.png
|   |   |   |           
|   |   |   +---editPost
|   |   |   |   |   addSeriesPopup.html
|   |   |   |   |   edit.html
|   |   |   |   |   save.html
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           imgIcon.png
|   |   |   |           
|   |   |   +---header
|   |   |   |   |   header.html
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           icon_black.png
|   |   |   |           icon_green.png
|   |   |   |           me_profile.png
|   |   |   |           search.png
|   |   |   |           
|   |   |   +---introduce
|   |   |   |   |   body.html
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           dog.jpg
|   |   |   |           emailIcon.png
|   |   |   |           githubIcon.png
|   |   |   |           icon_black.png
|   |   |   |           me_profile.png
|   |   |   |           search.png
|   |   |   |           yeondu.jpg
|   |   |   |           
|   |   |   +---kdy
|   |   |   |   |   body111.html
|   |   |   |   |   series.html
|   |   |   |   |   seriesDetail.html
|   |   |   |   |   seriesUpdate.html
|   |   |   |   |   series_bak.html
|   |   |   |   |   
|   |   |   |   \---imgs
|   |   |   |           baby.jpg
|   |   |   |           dog.jpg
|   |   |   |           emailIcon.png
|   |   |   |           githubIcon.png
|   |   |   |           icon_black.png
|   |   |   |           me_profile.png
|   |   |   |           noImage.png
|   |   |   |           noSeires.png
|   |   |   |           search.png
|   |   |   |           test.jpg
|   |   |   |           
|   |   |   +---login
|   |   |   |       login.html
|   |   |   |       
|   |   |   +---search
|   |   |   |       search.html
|   |   |   |       
|   |   |   +---setPage
|   |   |   |   |   setPage.html
|   |   |   |   |   setPageScript.js
|   |   |   |   |   
|   |   |   |   \---img
|   |   |   |           defaultImage.png
|   |   |   |           devJeans.png
|   |   |   |           email-icon.svg
|   |   |   |           facebook-icon.svg
|   |   |   |           github-icon.svg
|   |   |   |           home-icon.svg
|   |   |   |           twitter-icon.svg
|   |   |   |           
|   |   |   +---signup
|   |   |   |       register.html
|   |   |   |       
|   |   |   \---temporary
|   |   |           changeTemporary.html
|   |   |           edit_style.css
|   |   |           style.css
|   |   |           temporary.html
|   |   |           
|   |   \---templates
|   |       +---boardPost
|   |       |       changePost.html
|   |       |       post.html
|   |       |       
|   |       +---edit
|   |       |       addSeriesPopup.html
|   |       |       changeController.html
|   |       |       controller.html
|   |       |       edit.html
|   |       |       save.html
|   |       |       tempController.html
|   |       |       
|   |       +---editPost
|   |       |       edit.html
|   |       |       save.html
|   |       |       
|   |       +---fragments
|   |       |       footer.html
|   |       |       header.html
|   |       |       
|   |       +---header
|   |       |       header.html
|   |       |       
|   |       +---introduce
|   |       |       body.html
|   |       |       
|   |       +---login
|   |       |       login.html
|   |       |       
|   |       +---mainbody
|   |       |       body.html
|   |       |       
|   |       +---search
|   |       |       search.html
|   |       |       
|   |       +---series
|   |       |       series.html
|   |       |       seriesDetail.html
|   |       |       seriesUpdate.html
|   |       |       
|   |       +---setPage
|   |       |       setPage.html
|   |       |       
|   |       +---signup
|   |       |       register.html
|   |       |       
|   |       \---temporary
|   |               edit.html
|   |               save.html
|   |               tempController.html
|   |               temporary.html
|   \               
|                       
+---gradle
|   \---wrapper
|           gradle-wrapper.jar
|           gradle-wrapper.properties
|           
\---src
    +---main
    |   +---java
    |   |   \---com
    |   |       \---example
    |   |           \---welshcoding
    |   |               |   WelshcodingApplication.java
    |   |               |   
    |   |               +---controller
    |   |               |       BoardController.java
    |   |               |       EditController.java
    |   |               |       HomeController.java
    |   |               |       IntroduceController.java
    |   |               |       LoginController.java
    |   |               |       MemberController.java
    |   |               |       SaveController.java
    |   |               |       SeriesController.java
    |   |               |       SignupController.java
    |   |               |       TemporaryController.java
    |   |               |       
    |   |               +---domain
    |   |               |       Board.java
    |   |               |       Introduce.java
    |   |               |       Member.java
    |   |               |       Series.java
    |   |               |       Sns.java
    |   |               |       Tags.java
    |   |               |       Temporary.java
    |   |               |       
    |   |               +---dto
    |   |               |       BoardDTO.java
    |   |               |       LoginDTO.java
    |   |               |       MemberDTO.java
    |   |               |       SeriesListDTO.java
    |   |               |       TemporaryDTO.java
    |   |               |       
    |   |               +---exception
    |   |               |       MemberNotFoundException.java
    |   |               |       TagNullException.java
    |   |               |       
    |   |               +---interceptor
    |   |               |       LoginCheckInterceptor.java
    |   |               |       ReloadFilter.java
    |   |               |       WebConfig.java
    |   |               |       
    |   |               +---repository
    |   |               |       BoardRepository.java
    |   |               |       IntroduceRepository.java
    |   |               |       LoginRepository.java
    |   |               |       MemberRepository.java
    |   |               |       SeriesRepository.java
    |   |               |       SignupRepository.java
    |   |               |       TagRepository.java
    |   |               |       TemporaryRepository.java
    |   |               |       TestMemberRepository.java
    |   |               |       
    |   |               +---service
    |   |               |       BoardService.java
    |   |               |       IntroduceService.java
    |   |               |       LoginService.java
    |   |               |       MemberService.java
    |   |               |       SeriesService.java
    |   |               |       SignupService.java
    |   |               |       TagService.java
    |   |               |       TemporaryService.java
    |   |               |       TestMemberService.java
    |   |               |       
    |   |               \---testjiwon
    |   |                       TestSRepository.java
    |   |                       TestSService.java
    |   |                       TestTempoController.java
    |   |                       TestTemporaryRepository.java
    |   |                       TestTemporaryService.java
    |   |                       
    |   +---resources
    |   |   |   application.properties_bak
    |   |   |   application.yaml
    |   |   |   
    |   |   +---META-INF
    |   |   |       persistence.xml
    |   |   |       
    |   |   +---static
    |   |   |   |   index.html
    |   |   |   |   
    |   |   |   +---body1
    |   |   |   |   |   boardScript.js
    |   |   |   |   |   body.html
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           dog.jpg
    |   |   |   |           emailIcon.png
    |   |   |   |           facebookIcon.png
    |   |   |   |           githubIcon.png
    |   |   |   |           home-icon.png
    |   |   |   |           home-icon.svg
    |   |   |   |           icon_black.png
    |   |   |   |           me_profile.png
    |   |   |   |           search.png
    |   |   |   |           twiterIcon.png
    |   |   |   |           
    |   |   |   +---css
    |   |   |   |   |   edit_style.css
    |   |   |   |   |   footerStyle.css
    |   |   |   |   |   headerStyle.css
    |   |   |   |   |   introduce.css
    |   |   |   |   |   loginStyle.css
    |   |   |   |   |   mainbody.css
    |   |   |   |   |   postStyle.css
    |   |   |   |   |   registerStyle.css
    |   |   |   |   |   save_style.css
    |   |   |   |   |   seriesStyle.css
    |   |   |   |   |   setPage_styles.css
    |   |   |   |   |   signstyle.css
    |   |   |   |   |   tempstyle.css
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           corgi.png
    |   |   |   |           icon.png
    |   |   |   |           icon_grayScale.png
    |   |   |   |           icon_mid.png
    |   |   |   |           
    |   |   |   +---editPost
    |   |   |   |   |   addSeriesPopup.html
    |   |   |   |   |   edit.html
    |   |   |   |   |   save.html
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           imgIcon.png
    |   |   |   |           
    |   |   |   +---header
    |   |   |   |   |   header.html
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           icon_black.png
    |   |   |   |           icon_green.png
    |   |   |   |           me_profile.png
    |   |   |   |           search.png
    |   |   |   |           
    |   |   |   +---introduce
    |   |   |   |   |   body.html
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           dog.jpg
    |   |   |   |           emailIcon.png
    |   |   |   |           githubIcon.png
    |   |   |   |           icon_black.png
    |   |   |   |           me_profile.png
    |   |   |   |           search.png
    |   |   |   |           yeondu.jpg
    |   |   |   |           
    |   |   |   +---kdy
    |   |   |   |   |   body111.html
    |   |   |   |   |   series.html
    |   |   |   |   |   seriesDetail.html
    |   |   |   |   |   seriesUpdate.html
    |   |   |   |   |   series_bak.html
    |   |   |   |   |   
    |   |   |   |   \---imgs
    |   |   |   |           baby.jpg
    |   |   |   |           dog.jpg
    |   |   |   |           emailIcon.png
    |   |   |   |           githubIcon.png
    |   |   |   |           icon_black.png
    |   |   |   |           me_profile.png
    |   |   |   |           noImage.png
    |   |   |   |           noSeires.png
    |   |   |   |           search.png
    |   |   |   |           test.jpg
    |   |   |   |           
    |   |   |   +---login
    |   |   |   |       login.html
    |   |   |   |       
    |   |   |   +---search
    |   |   |   |       search.html
    |   |   |   |       
    |   |   |   +---setPage
    |   |   |   |   |   setPage.html
    |   |   |   |   |   setPageScript.js
    |   |   |   |   |   
    |   |   |   |   \---img
    |   |   |   |           defaultImage.png
    |   |   |   |           devJeans.png
    |   |   |   |           email-icon.svg
    |   |   |   |           facebook-icon.svg
    |   |   |   |           github-icon.svg
    |   |   |   |           home-icon.svg
    |   |   |   |           twitter-icon.svg
    |   |   |   |           
    |   |   |   +---signup
    |   |   |   |       register.html
    |   |   |   |       
    |   |   |   \---temporary
    |   |   |           changeTemporary.html
    |   |   |           edit_style.css
    |   |   |           style.css
    |   |   |           temporary.html
    |   |   |           
    |   |   \---templates
    |   |       +---boardPost
    |   |       |       changePost.html
    |   |       |       post.html
    |   |       |       
    |   |       +---edit
    |   |       |       addSeriesPopup.html
    |   |       |       changeController.html
    |   |       |       controller.html
    |   |       |       edit.html
    |   |       |       save.html
    |   |       |       tempController.html
    |   |       |       
    |   |       +---editPost
    |   |       |       edit.html
    |   |       |       save.html
    |   |       |       
    |   |       +---fragments
    |   |       |       footer.html
    |   |       |       header.html
    |   |       |       
    |   |       +---header
    |   |       |       header.html
    |   |       |       
    |   |       +---introduce
    |   |       |       body.html
    |   |       |       
    |   |       +---login
    |   |       |       login.html
    |   |       |       
    |   |       +---mainbody
    |   |       |       body.html
    |   |       |       
    |   |       +---search
    |   |       |       search.html
    |   |       |       
    |   |       +---series
    |   |       |       series.html
    |   |       |       seriesDetail.html
    |   |       |       seriesUpdate.html
    |   |       |       
    |   |       +---setPage
    |   |       |       setPage.html
    |   |       |       
    |   |       +---signup
    |   |       |       register.html
    |   |       |       
    |   |       \---temporary
    |   |               edit.html
    |   |               save.html
    |   |               tempController.html
    |   |               temporary.html

```
