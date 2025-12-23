document.addEventListener('DOMContentLoaded', function() {
    const app = new Vue({
        el: '#detailApp',
        data: {
            memberDetails: null, // 用于存储选中的党员详细信息
        },
        mounted() {
            this.fetchMemberDetails(); // 页面加载时获取党员列表
        },
        methods: {
            getMsg(){
                const that = this;
                this.msg = localStorage.getItem("id");
            }
        },
        methods: {
            async fetchMemberDetails() {
                id = localStorage.getItem("id");
                try {
                    const data = {
                        id,
                    };
                    const response = await fetch('/Party_war_exploded/DetailServlet', {
                        method: 'POST',
                        data:{
                            id:id
                        },
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8'
                        },
                        body: JSON.stringify(data)
                    });
                    if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
                    //const memberDetailsResponse = await response.json();
                   // console.log('获取到的党员详细信息:', memberDetailsResponse);
                    this.memberDetails = await response.json();
                } catch (error) {
                    console.error('获取党员详细信息失败:', error);
                }
            }

        },
        });
});