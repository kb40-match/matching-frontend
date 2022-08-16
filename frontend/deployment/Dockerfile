FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn install --production
RUN yarn add @vue/cli-service
COPY . .
RUN yarn build

FROM nginx:stable-alpine as production-stage
# RUN mkdir /app
COPY --from=build-stage /app/deployment/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-stage /app/dist /usr/share/nginx/html
# COPY --from=build-stage /app/dist /app
# COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
