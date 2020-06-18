<template>
    <div id="BoardTest">
        <button @click="loadBoard">
        더 보기
        </button>
        <table class="table table-dark">
            <thead>
                <tr class="text-center">
                    <td scope="col">글번호</td>
                    <td scope="col">글제목</td>
                    <td scope="col">작성자</td>
                    <td scope="col">작성일</td>
                </tr>
            </thead>
            <tbody>
                <tr v-for="data in qnaDatas" v-bind:key="data.qnaNo" class="text-center">
                    <td scope="row">{{data.qnaNo}}</td>
                    <td>{{data.qnaTitle}}</td>
                    <td>{{data.qnaUserid}}</td>
                    <td>{{data.qnaDatetime}}</td>
                </tr>
            </tbody>
        </table>
        <!--
        <div class="text-right">
            <b-button  @click="writeContent">글쓰기</b-button>
        </div>
        -->
    </div>
    
</template>

<script>
import axios from 'axios';
export default {
    name: 'BoardTest',
    data() {
        return {
            qnaDatas: []
        }
    },
    methods: {
        loadBoard(){
            axios.get('http://localhost:9999/happyhouse/api/qna/selectAll')
            .then(res => {
                this.qnaDatas = res.data;
            }).catch(e => {
                console.error(e)
            })
        },
        writeContent() {
          this.$router.push({
            path: `/BoardCreate`
          });
        },
    },
}
</script>