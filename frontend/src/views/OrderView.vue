<script setup>
import { ref } from 'vue';

const order  = ref(null);

// Simple POST request with a JSON body using fetch
const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({customerId:1,products:{"1": 10, "2": 5, "3": 12}})
};
fetch('http://localhost:8082/v1/orders', requestOptions)
    .then(response => response.json())
    .then(data => order.value = data);
</script>

<template>
    <div class="card text-center m-3">
        <h5 class="card-header">Order Details</h5>
        <div class="card-body">Order id: {{order?.id}}, Total Price: {{order?.totalCost}}</div>
    </div>
</template>
