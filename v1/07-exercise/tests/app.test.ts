import request from 'supertest';
import app from '../src/index';

describe('GET /', () => {
  it('returns greeting message', async () => {
    const res = await request(app).get('/');
    expect(res.statusCode).toBe(200);
    expect(res.body.message).toBe('Hello from TypeScript app!');
  });
});
