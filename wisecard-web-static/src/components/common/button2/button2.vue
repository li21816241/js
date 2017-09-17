<template>
<section>
	<div class="eb">
		<div class="eb1">
			<div class="eb2">
			</div>
			<div class="eb21">
				<input type="button" :value="caption"  @click="click" class="center"></input>
			</div>
		</div>
	</div>
</section>
</template>
<script>
  export default {
		props:[ 'caption', 'bmp', 'callback' ],
		data(){
			return {};
		},
		methods:{
			click(){
				this.$emit( 'click', this.caption );				
			}
		}
  }
</script>
