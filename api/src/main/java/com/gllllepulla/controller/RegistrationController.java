package com.gllllepulla.controller;

import com.gllllepulla.model.Info;
import com.gllllepulla.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/registration")
class RegistrationController {

    private final UserService userService;
    private final Model model;

    @Operation(summary = "Запрос формы регистрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping
    public String getRegistrationForm() {
        Info.BookishUser user = new Info.BookishUser(null, "", "", false, false, false, false);
        model.addAttribute("userForm", user);
        return "registration";
    }

    @Operation(summary = "Регистрация")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping
    public String registrationUser(@ModelAttribute("userForm") @Valid Info.BookishUser userForm) {
        Optional<Info.BookishUser> bookishUser = userService.addUser(userForm);
        if (bookishUser.isEmpty()) {
            model.addAttribute("userNameError", "this name is already exist");
            return "registration";
        } else {
            return "redirect:/login";
        }
    }

}
