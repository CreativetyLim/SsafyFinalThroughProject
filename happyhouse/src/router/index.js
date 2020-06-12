import Vue from "vue";
import VueRouter from "vue-router"; 
import QnABoard from "@/components/board/QnABoard";
import BoardDetail from "@/components/board/BoardDetail";
import BoardCreate from "@/components/page/Create.vue";
import BoardUpdate from "@/components/page/Update.vue";
import BoardTest from "@/components/board/BoardTest";
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
      path:"/BoardUpdate",
      name:"BoardUpdate",
      component:BoardUpdate,
    },
    {
      path:"/BoardTest",
      name:"BoardTest",
      component:BoardTest,
    },
    // {
    //   path: "*",
    //   component: NotFound
    // }
  ]
});
