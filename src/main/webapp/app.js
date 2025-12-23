document.addEventListener('DOMContentLoaded', function() {
    const app = new Vue({
        el: '#app',
        data: {
            partyMembers: [], // 党员列表，初始为空
        },
        mounted() {
            this.fetchPartyMembers(); // 页面加载时获取党员列表
        },
        methods: {
            async fetchPartyMembers() {
                try {
                    const response = await fetch('/Party_war_exploded/PeopleServlet'); // 假定的API路径，请替换为实际路径
                    if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
                    this.partyMembers = await response.json();
                } catch (error) {
                    console.error('获取党员列表失败:', error);
                }
            },

            async sviewDetail(partyVolunteerId) {
                try {
                    const data = {
                        partyVolunteerId,
                    };
                    const response = await fetch('/Party_war_exploded/DetailServlet', {
                        method: 'POST', // 或者使用 'PUT'，根据您的后端接口设计
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8'
                        },
                        body: JSON.stringify(data)
                    });
                    //localStorage.setItem("id",result.data.partyVolunteerId);

                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }

                    alert('查询成功');
                    window.location.href='detail.html'
                } catch (error) {
                    console.error('查询失败:', error);
                    // 错误处理逻辑
                }
            }

        },


    });
});