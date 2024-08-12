package com.example.yakbang.controller.admin;

import com.example.yakbang.dto.admin.AdminExMemberDTO;
import com.example.yakbang.dto.admin.AdminMemberDTO;
import com.example.yakbang.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/members")
@RequiredArgsConstructor
public class AdminMemberController {

    private final AdminService adminService;

    @GetMapping("/{memberType}/{userId}")
    public ResponseEntity<?> getMemberByTypeAndId(
            @PathVariable("memberType") String memberType,
            @PathVariable("userId") Long userId) {

        if ("expert".equalsIgnoreCase(memberType)) {
            List<AdminExMemberDTO> expertMembers = adminService.findExpertMembers(userId);
            if (!expertMembers.isEmpty()) {
                return ResponseEntity.ok(expertMembers);
            }
        } else if ("general".equalsIgnoreCase(memberType)) {
            List<AdminMemberDTO> generalMembers = adminService.findGeneralMembers(userId);
            if (!generalMembers.isEmpty()) {
                return ResponseEntity.ok(generalMembers);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/updateGeneral")
    public ResponseEntity<Map<String, Object>> updateGeneral(@RequestBody AdminMemberDTO updatedData) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 일반 회원 업데이트 로직
            adminService.modifyGeneralMember(updatedData);

            response.put("success", true);
            response.put("message", "회원 정보가 성공적으로 업데이트되었습니다.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "업데이트 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/updateExpert")
    public ResponseEntity<Map<String, Object>> updateExpert(@RequestBody AdminExMemberDTO updatedData) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 업데이트 로직
            adminService.modifyExpertMember(updatedData);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "업데이트 실패");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/deleteGeneral/{userId}")
    public void deleteGeneral(@PathVariable("userId") Long userId) {
        adminService.deleteGeneralMember(userId);
    }
    @DeleteMapping("/deleteExpert/{userId}")
    public void deleteExpert(@PathVariable("userId") Long userId) {
        adminService.deleteExpertMember(userId);
    }
}