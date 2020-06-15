import Vue from "vue";
import VueRouter from "vue-router"; 
// 게시판
import QnABoard from "@/components/board/QnABoard";
import BoardDetail from "@/components/board/BoardDetail";
import BoardCreate from "@/components/board/BoardCreate";
import BoardUpdate from "@/components/page/Update";
import BoardTest from "@/components/board/BoardTest";


// 유저관련
import SignUp from "@/components/user/SignUp"
import Login from "@/components/user/Login"

//import NotFound from "@/components/NotFound";

Vue.use(VueRouter); // 뷰 어플리케이션에 라우터 플러그인을 추가한다.

// 라우터 객체를 생성
const router =  new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "QnABoard",
      component: QnABoard
    },
    {
      path: "/board/detail/:contentId",
      name: "BoardDetail",
      component: BoardDetail
    },
    {
      path: "/BoardCreate",
      name: "BoardCreate",
      component: BoardCreate
    },
    {
      path: "/board/BoardUpdate",
      name: "BoardUpdate",
      component:BoardUpdate,
    },
    {
      path: "/BoardTest",
      name: "BoardTest",
      component:BoardTest,
    },
    {
      path: "/SignUp",
      name: "SignUp",
      component: SignUp,
    },
    {
      path: "/Login",
      name: "Login",
      component: Login,
    },
    // {
    //   path: "*",
    //   component: NotFound
    // }
  ]
});

export{
  router,
}