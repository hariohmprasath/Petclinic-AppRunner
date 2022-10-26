/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.env;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class EnvController {

	@GetMapping("/envs.html")
	public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
		return addPaginationModel(model);
	}

	private String addPaginationModel(Model model) {
		Envs envs = new Envs();
		System.getenv().forEach((k, v) -> {
			envs.getEnvList().add(new Env(k, v));
		});
		model.addAttribute("currentPage", 1);
		model.addAttribute("totalPages", 1);
		model.addAttribute("totalItems", envs.getEnvList().size());
		model.addAttribute("listEnvs", envs.getEnvList());
		return "envs/envList";
	}

}
