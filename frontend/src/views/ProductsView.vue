<script setup>
import { ref } from 'vue';

const products = ref(null);
fetch('http://localhost:8081/v1/products')
    .then(response => response.json())
    .then(data => products.value = data);

</script>

<template>
  <main>
    <div class="card m-3">
        <h5 class="card-header text-center">Drinks Shop</h5>
        <div class="card-body">
            <div v-if="products">
                <h5>Products</h5>
                <ul class="mb-0">
                    <li v-for="product in products" :key="product.id">{{product.name}}</li>
                </ul>
            </div>
            <div v-if="!products" class="text-center">
                <div class="spinner-border spinner-border-sm"></div>
            </div>
        </div>
    </div>
    <div>Test</div>
  </main>
</template>
