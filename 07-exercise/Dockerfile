FROM node:18-alpine
WORKDIR /app
COPY dist/ ./dist/
COPY package*.json ./
RUN npm ci --omit=dev
EXPOSE 3000
CMD ["node", "dist/index.js"]
