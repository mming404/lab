#include <httplib.h>
#include <nlohmann/json.hpp>
#include <string>
#include <iostream>

using json = nlohmann::json;

int main() {
    httplib::Server svr;

    // 根路由返回欢迎信息
    svr.Get("/", [](const httplib::Request& req, httplib::Response& res) {
        json response = {
            {"message", "Welcome to Simple REST Server"},
            {"endpoints", {
                {"GET /hello?name=NAME", "Greeting endpoint"},
                {"GET /query?params", "Echo parameters"}
            }}
        };
        res.set_header("Content-Type", "application/json");
        res.body = response.dump();
    });

    // 带参数的问候接口
    svr.Get("/hello", [](const httplib::Request& req, httplib::Response& res) {
        std::string name = req.get_param_value("name");
        if (name.empty()) name = "Anonymous";

        json response = {
            {"greeting", "Hello " + name + "!"},
            {"received_name", name}
        };
        res.set_header("Content-Type", "application/json");
        res.body = response.dump();
    });

    // 参数回显接口
    svr.Get("/query", [](const httplib::Request& req, httplib::Response& res) {
        json params_json;
        for (auto& param : req.params) {
            params_json[param.first] = param.second;
        }

        json response = {
            {"status", "OK"},
            {"received_parameters", params_json}
        };
        res.set_header("Content-Type", "application/json");
        res.body = response.dump();
    });

    // 错误处理示例
    svr.set_error_handler([](const httplib::Request&, httplib::Response& res) {
        json response = {
            {"error", "Invalid request"},
            {"status_code", res.status}
        };
        res.set_header("Content-Type", "application/json");
        res.body = response.dump();
    });

    std::cout << "Server running at http://localhost:8080\n";
    svr.listen("localhost", 8080);
    return 0;
}