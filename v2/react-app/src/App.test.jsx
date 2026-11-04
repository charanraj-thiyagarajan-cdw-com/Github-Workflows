import { describe, it, expect } from "vitest";
import React from "react";
import App from "./App";

describe("App Component", () => {
  it("instantiates correctly", () => {
    expect(App).toBeDefined();
    const element = React.createElement(App);
    expect(element.type).toBe(App);
  });
});
