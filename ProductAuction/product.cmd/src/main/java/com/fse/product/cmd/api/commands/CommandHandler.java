package com.fse.product.cmd.api.commands;

public interface CommandHandler {
    void handle(AddProductCommand command);
    void handle(DeleteProductCommand command);
}
