module.exports = {
    assetsDir: "static",
    outputDir: "../src/main/resources/static",
    indexPath: "../templates/index.html",
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:9999',
                ws: true,
                changeOrigin: true
            }
        }
    }
}