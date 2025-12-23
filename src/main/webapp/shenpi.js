document.addEventListener('DOMContentLoaded', function() {
    const app = new Vue({
        el: '#app',
        data: {
            partyMembers: [], // 党员列表，初始为空，等待数据填充
        },
        mounted() {
            this.fetchPartyMembers(); // 页面加载时获取党员列表
        },
        methods: {
            async fetchPartyMembers() {
                try {
                    const response = await fetch('/Party_war_exploded/ShenpiServlet'); // 假定的API路径，请替换为实际路径
                    if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
                    this.partyMembers = await response.json();
                } catch (error) {
                    console.error('获取党员列表失败:', error);
                }
            },

            async shenpihan(partyVolunteerId) {
                try {
                    const data = {
                        partyVolunteerId,
                    };

                    // 发送POST请求到后端更新党员审批状态
                    const response = await fetch('/Party_war_exploded/UpdateServlet', {
                        method: 'POST', // 或者使用 'PUT'，根据您的后端接口设计
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8'
                        },
                        body: JSON.stringify(data)
                    });

                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }

                    // 成功提示
                    alert('审批操作成功');

                    // 重新获取党员列表或根据需要处理
                    // this.fetchPartyMembers();

                } catch (error) {
                    console.error('审批操作失败:', error);
                    // 错误处理逻辑
                }
            },


        },


    });
});