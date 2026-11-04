import express from 'express';

const app = express();

app.get('/', (_req, res) => {
  res.json({ message: 'Hello from TypeScript app!' });
});

if (process.env.NODE_ENV !== 'test') {
  const PORT = process.env.PORT || 3000;
  app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
  });
}

export default app;
