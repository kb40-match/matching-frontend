const path = require("path");

module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  lintOnSave: false,
  chainWebpack: (config) => {
    // root dirs
    config.resolve.alias.set("@", path.resolve(__dirname, "src/"));
    config.resolve.alias.set("@@", path.resolve(__dirname, "/"));

    // SVG loader
    const svgRule = config.module.rule("svg");

    svgRule.uses.clear();

    svgRule
      .use("babel-loader")
      .loader("babel-loader")
      .end()
      .use("vue-svg-loader")
      .loader("vue-svg-loader");
  },
  css: {
    loaderOptions: {
      scss: {
        data: `
          @use "@/styles/constants/colors.scss";
          @import "@/styles/global/index.scss";
          @import "@/styles/global/reset.scss";
        `,
      },
    },
  },
  devServer: {
    proxy: "http://matching.169.56.100.104.nip.io/match",
  },
};
