import Vue from "vue";
import VueRouter from "vue-router"; 
import QnABoard from "@/components/board/QnABoard";
//import BoardDetail from "@/components/board/BoardDetail";
//import BoardCreate from "@/components/board/BoardCreate";

//import NotFound from "@/components/NotFound";

Vue.use(VueRouter); // 뷰 어플리케이션에 라우터 플러그인을 추가한다.

// 라우터 객체를 생성
export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "QnABoard",
      component: QnABoard
    },
    // {
    //   path: "/board/detail/:contentId",
    //   name: "BoardDetail",
    //   component: BoardDetail
    // },
    // {
    //   path: "/board/create/:contentId?",
    //   name: "BoardCreate",
    //   component: BoardCreate
    // },
    // {
    //   path: "*",
    //   component: NotFound
    // }
  ]
});
