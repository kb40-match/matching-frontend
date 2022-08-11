const path = require("path");

module.exports = {
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
      sass: {
        data: `
          @use "@/styles/constants/colors.scss";
          @import "@/styles/global/index.scss";
          @import "@/styles/global/reset.scss";
        `,
      },
    },
  },
};
