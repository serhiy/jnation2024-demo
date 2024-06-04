<script>
import http from 'http';

http.get('http://localhost:8081/v1/products', res => {
  let data = [];
  const headerDate = res.headers && res.headers.date ? res.headers.date : 'no response date';
  console.log('Status Code:', res.statusCode);
  console.log('Date in Response header:', headerDate);

  res.on('data', chunk => {
    data.push(chunk);
  });

  res.on('end', () => {
    console.log('Response ended: ');
    const users = JSON.parse(Buffer.concat(data).toString());
  });
}).on('error', err => {
  console.log('Error: ', err.message);
});
</script>

<template>
  <main>
    <div />
  </main>
</template>
