<template>
<section>
	<div class="row">
		<div class="col-lg-12">
			<div class="page-header">
				<input type="button" text={{caption}} :click="callback"></input>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
</section>
</template>
<script>
  export default {
		props:[ 'caption', 'bmp', 'callback' ],
  }
</script>
