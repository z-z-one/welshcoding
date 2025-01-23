# Welshcoding
</br>

velog를 레퍼런스로한 SpringBoot 프로젝트입니다.

</br>

### 프로젝트 설명

- <a  href="https://miniature-globe-4cc.notion.site/Spring-Boot-Welshcoding-184178242f938015b0a5d9f8a1688e14" target="_blank"> 프로젝트 설명 노션 바로가기 링크</a> : 개발 과정과 자세한 설명을 확인 할 수 있습니다.

</br></br>

### Welshcoding 배포 사이트

- <a  href="https://port-0-welshcoding-rm6l2llvw6yzvu.sel5.cloudtype.app/" target="_blank"> Welshcoding 배포된 싸이트 바로가기</a> : 개발된 프로젝트를 직접 체험 할 수 있습니다.
    - DB 배포 : AWS
    - 프로젝트 배포 : cloudtype
    - DB연결정보는 깃허브에 올리지 않았습니다.(변수처리) - application.yaml




</br> 

------ 

</br></br> 

### 프로젝트 소스 구조

```
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
