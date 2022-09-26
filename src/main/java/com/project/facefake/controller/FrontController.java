package com.project.facefake.controller;

import com.project.facefake.controller.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand command= getCommand(req);

    }

    private FrontCommand getCommand(HttpServletRequest req) {
        try {
            Class type = Class.forName(String.format(
                    "com.project.facefake."
                            + "controllers.commands.%sCommand",
                    req.getParameter("command")));
            return (FrontCommand) type
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}
