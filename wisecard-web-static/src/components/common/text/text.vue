<template>
<section>
	<div class="row">
		<div class="col-lg-12">
			<div class="page-header">
				<input type="text" disabled="disabled" style="background:none;">{{context}}</input>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
</section>
</template>
<script>
  export default {
		props:[ 'context' ],
  }
</script>
