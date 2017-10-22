FROM nginx:alpine
LABEL maintainer="hiper2d"
COPY config/nginx/default.conf /etc/nginx/conf.d/

## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*

COPY dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]