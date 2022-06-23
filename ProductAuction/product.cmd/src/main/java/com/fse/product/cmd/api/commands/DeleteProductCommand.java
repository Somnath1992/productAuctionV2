package com.fse.product.cmd.api.commands;


import com.fse.cqrs.core.commands.BaseCommand;

public class DeleteProductCommand extends BaseCommand {
    public DeleteProductCommand(String id) {
        super(id);
    }
}
