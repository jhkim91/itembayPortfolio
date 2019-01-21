var app = new Vue({
	el: '#app',
	data: {
		mode: 'list',
		memo: {
			cn: null,
			content: null
		},
		memos: [
			/*{
				id:1,
				content: '메모 #1',
				regDate: new Date()
			},
			{
				id:2,
				content: '메모 #2',
				regDate: new Date()
			},
			{
				id:3,
				content: '메모 #3',
				regDate: new Date()
			}*/
		]
	},
	methods: {
		renew: function(val){
			return JSON.parse(JSON.stringify(val)); // 참조값이 들어올경우 JSON.stringify를 사용해서 값으로 만듦
		},
		open: function(id){
			for(var i in this.memos){
				if(this.memos[i].id === id){
					this.memo = this.renew(this.memos[i]); // 갚 대입 외에도 참조에도 사용하기에 값만넘길것.
					break;
				}
			}
			this.mode = 'edit';
		},
		write: function(){
			this.mode = 'write';
			this.memo = {
				cn: null,
				content: null
			}
		},
		save: function(){
//////////////////////////////////////////////////////
			const self = this;
			axios.post('/comment/insert', {
				seq: document.frm.seq.value,
				content: this.memo.content
			})
			.then(function (response){
				console.log(response.data);
				self.list();
//				self.memo.content=response.data.item;
			})
			.catch(function (error){
				console.log(error);
			})
//////////////////////////////////////////////////////
			var id = this.memos.length +1;
			
			if(this.mode === 'write'){
				this.memos.push({
					cn: cn,
					content: this.memo.content,
					regDate: new Date()
				});
			}
			else if(this.mode === 'edit'){
				for(var i in this.memos){
					if(this.memos[i].cn === this.memo.cn){
						//this.memo[i].content = this.memo.content;
						this.memos[i] = this.renew(this.memo);
						break;
					}
				}
			}
			
			this.mode = 'list';
			
//			localStorage.setItem('memos', JSON.stringify(this.memos));
		},
		list: function(){
			//////////////////////////////////////////////////////
			const self = this;
			axios.post('/comment/list', {
				seq: document.frm.seq.value
			})
			.then(function (response){
				console.log(">>>>>>>>>");
				for(var data in response.data){
					console.log(response.data[data]);
					self.memos[data] = JSON.parse(JSON.stringify(response.data[data]));
				}
				console.log(self.memos);
			})
			.catch(function (error){
				console.log(error);
			})
			//////////////////////////////////////////////////////
		},
		remove: function(){
			if(confirm('삭제하시곘습니까?')){
				for(var i in this.memos){
					if(this.memos[i].id === this.memo.id){
						//this.memo[i].content = this.memo.content;
						this.memos.splice(i, 1);
						break;
					}
				}
//				localStorage.setItem('memos', JSON.stringify(this.memos));
				this.mode = 'list';
			}
		}
	},
	created: function(){
		this.mode = 'list';
//		var memos = localStorage.getItem('memos');

		if(memos){
			this.memos = JSON.parse(memos);
		}
		
	}
})